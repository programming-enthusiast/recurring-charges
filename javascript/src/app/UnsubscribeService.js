'use strict';

import StatementApi from '../lib/statementApi.js';
import _ from 'lodash';

class UnsubscribeService {
  displayRecurringCharges() {
    let billStatement = {};
    let recurringCharges = {};

    _.forEach(StatementApi.getCharges(), (charge) => {
      const name = charge.name;
      billStatement[name] = billStatement[name] || 0;
      billStatement[name] += 1;
    });

    _.forEach(billStatement, (chargeCount, chargeName) => {
      if (chargeCount >= 1) {
        _.set(recurringCharges, chargeName, chargeCount);
      }
    });

    return recurringCharges;
  }
}

export default UnsubscribeService;
