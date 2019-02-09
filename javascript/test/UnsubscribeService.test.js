'use strict';

import StatementApi from '../src/lib/statementApi.js';
import UnsubscribeService from '../src/app/UnsubscribeService.js'
import _ from 'lodash';

describe('UnsubscribeService', () => {
  describe('#displayRecurringCharges', () => {
    const subject = new UnsubscribeService();
    const sampleName = "Spotify";
    const sampleDate = "1/1/18";
    const sampleAmount = 9.99;

    let statementCharges = [];

    function createCharge(name, date, amount) {
      statementCharges.push({
        name: name,
        date: date,
        amount: amount,
      })
    }

    beforeEach(() => {
      statementCharges = [];
      jest.spyOn(StatementApi, 'getCharges').mockImplementation(() => statementCharges);
    });

    test('sums the charges that occur more than once', () => {
      createCharge(sampleName, "1/1/18", sampleAmount);
      createCharge(sampleName, "1/2/18", sampleAmount);

      const recurringCharges = subject.displayRecurringCharges();
      expect(recurringCharges[sampleName]).toBe(2);
    });

    test('does not include charges that only occur once', () => {
      createCharge(sampleName, sampleDate, sampleAmount)

      const recurringCharges = subject.displayRecurringCharges();
      expect(recurringCharges[sampleName]).toBeUndefined();
    });
  });
});
