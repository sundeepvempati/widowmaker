/*
 * Copyright 2003-2016 MarkLogic Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package test.sql;

import java.util.HashMap;
import java.util.Random;
import test.utilities.ParseFieldManager;
import test.utilities.BaseParseField;

import org.w3c.dom.Node;

public class ValidTradeStatusField
                extends BaseParseField {

  private String[] statuses = { "VALID", "FILED", "TRANSACTED", "FULFILLED", "SETTLED" };
  private Random randNum;

  public static final String TOKEN = "__VALID_TRADE_STATUS__";

  public ValidTradeStatusField() {
    super();
    token = TOKEN;
    randNum = new Random();
  }

  public ValidTradeStatusField(String token) {
    super();
    randNum = new Random();
    if (token == null)
      this.token = TOKEN;
    else
      this.token = token;
  }

  public void initialize(ParseFieldManager mgr, Node t) {

    // record = getRandomCustomer();
  }

  public String generateData(String token) {
    String status = getRandomTradeStatus();

    // System.out.println("Returning trade status of " + status);

    return status;
  }

  public String generateData(String token, HashMap extra) {
    return generateData(token);
  }

  public String getRandomTradeStatus() {

    int pos = -1;

    while (pos < 0) {
      pos = randNum.nextInt() % statuses.length;
    }

    return statuses[pos];

  }
}


