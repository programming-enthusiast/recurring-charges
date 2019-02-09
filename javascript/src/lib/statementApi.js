'use strict';

import chargeList from '../config/charges.js';

class StatementApi {
  static getCharges() {
    return chargeList.charges;
  }
}

export default StatementApi;
