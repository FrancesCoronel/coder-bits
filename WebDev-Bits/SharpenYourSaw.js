Synchronous Programming


    var _ = require("lodash");

    var getSquare = function (n) {
      return n * n;
    };

    var squares = _.map([1, 2, 3], getSquare);
    console.log(squares);
    // [1, 4, 9]
  
Asynchronous Programming


    var getSquareAsync = function (n, done) {
      setTimeout(function () {
        if (_.isFunction(done)) {
          done(null, n * n);
        }
      }, 1000);
    };

    var squareAsyncWrong = getSquareAsync(1);
    console.log(squareAsyncWrong);
    // undefined

    var squareAsyncCorrect = getSquareAsync(3, function (err, result) {
      console.log(result);
    });
    // 9
  
Using Async Map


    var async = require("async");

    var squareAsyncMapWrong = _.map([1, 2, 3], getSquareAsync);
    console.log(squareAsyncWrong);
    // [ undefined, undefined, undefined ]

    var squaresAsyncMapCorrect = async.map([1, 2, 3], getSquareAsync, function (err, results) {
      console.log(results);
    });
    // [1, 4, 9]

  
A More Practical Async Request


    var request = require("request");
    var key = "TZlKw4gd1qFQhA2CbMLa";
    var urlBase = "http://thesaurus.altervista.org/service.php?language=en_US&output=json&key=" + key + "&word=";

    request(urlBase + "mock", function (err, response, body) {
      var responseObj = JSON.parse(body);
      console.log(JSON.stringify(responseObj, null, 2));
    });
    // {
    //   "response": [
    //     {
    //       "list": {
    //         "category": "(adj)",
    //         "synonyms": "counterfeit (similar term)|imitative (similar term)"
    //       }
    //     },
    //     {
    //       "list": {
    //         "category": "(noun)",
    //         "synonyms": "derision|ridicule"
    //       }
    //     },
    //     {
    //       "list": {
    //         "category": "(verb)",
    //         "synonyms": "bemock|treat|handle|do by"
    //       }
    //     },
    //     {
    //       "list": {
    //         "category": "(verb)",
    //         "synonyms": "imitate|copy|simulate"
    //       }
    //     }
    //   ]
    // }
  