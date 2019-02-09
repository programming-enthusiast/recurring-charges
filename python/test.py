import unittest
from unittest.mock import MagicMock

from app.unsubscribe_service import UnsubscribeService
from app.statement_api import StatementAPI

class TestUnsubscribeService(unittest.TestCase):

    def test_does_not_include_charges_that_only_occur_once(self):
        mock = MagicMock()
        mock.return_value = [
            {
                "name": "Spotify",
                "date": "1/1/2019",
                "amount": "9.99"
            }
        ]
        StatementAPI.get_charges = mock

        result = UnsubscribeService.display_recurring_charges()
        key_presence = "Spotify" in result
        self.assertEqual(key_presence, False)

    def test_sums_the_charges_that_occur_more_than_once(self):
        mock = MagicMock()
        mock.return_value = [
            {
                "name": "Spotify",
                "date": "1/1/2019",
                "amount": "9.99"
            },
            {
                "name": "Spotify",
                "date": "2/1/2019",
                "amount": "9.99"
            }
        ]
        StatementAPI.get_charges = mock

        result = UnsubscribeService.display_recurring_charges()
        self.assertEqual(result["Spotify"], 2)

if __name__ == '__main__':
    unittest.main()
