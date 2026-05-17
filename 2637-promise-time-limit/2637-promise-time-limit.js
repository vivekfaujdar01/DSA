/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    return async function(...args) {

        return new Promise((resolve, reject) => {

            let isFinished = false;

            const timer = setTimeout(() => {

                if (!isFinished) {
                    isFinished = true;
                    reject("Time Limit Exceeded");
                }

            }, t);

            fn(...args)
                .then((result) => {

                    if (!isFinished) {
                        isFinished = true;

                        clearTimeout(timer);

                        resolve(result);
                    }

                })
                .catch((error) => {

                    if (!isFinished) {
                        isFinished = true;

                        clearTimeout(timer);

                        reject(error);
                    }

                });

        });
    };
    // we can use Promise.race() We race two promises against each other, whichever finishes first wins.
    // return async function(...args) {

    //     const timeoutPromise = new Promise((_, reject) => {
    //         setTimeout(() => {
    //             reject("Time Limit Exceeded");
    //         }, t);
    //     });

    //     return Promise.race([fn(...args), timeoutPromise ]);
    // }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */