import StatementApi from '../src/lib/statementApi.js';
import UnsubscribeService from '../src/app/UnsubscribeService.js'
import _ from 'lodash';

describe('UnsubscribeService', () => {
  describe('#getPriceMap', () => {
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

    test('gets recent prices', () => {

      createCharge(sampleName, "1/1/2018", 5.99);
      createCharge(sampleName, "3/1/2018", 4.76);
      createCharge(sampleName, "5/1/2018", 6.99);

      const priceMap = subject.getPriceMap();

      expect(priceMap[sampleName].date).toBe('5/1/2018');
      expect(priceMap[sampleName].amount).toBe(6.99);
    });
  });
});
