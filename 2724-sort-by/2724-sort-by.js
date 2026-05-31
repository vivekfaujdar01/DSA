/**
 * @param {Array} arr
 * @param {Function} fn
 * @return {Array}
 */
 // In js .sort() method mutate the input and as well as return value.
 // If we don't want to mutate the input, we can use .toSorted() method.
var sortBy = function(arr, fn) {
    // return arr.sort((a, b) => fn(a) - fn(b));
    return arr.toSorted((a, b) => fn(a) - fn(b));
};