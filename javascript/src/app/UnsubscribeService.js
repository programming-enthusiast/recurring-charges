import StatementApi from '../lib/statementApi.js';
import _ from 'lodash';

class UnsubscribeService {
  getPriceMap() {
    let priceMap = {};

    _.forEach(StatementApi.getCharges(), (charge) => {
      if (priceMap[charge.name] !== undefined) {
        const dateA = new Date(priceMap[charge.name].date)
        const dateB = new Date(charge.date)
        if (dateA < dateB)
          priceMap[charge.name] = { amount: charge.amount, date: charge.date }
      } else {
        priceMap[charge.name] = { amount: charge.amount, date: charge.date }
      }

    });

    return priceMap;
  }
}

export default UnsubscribeService;
