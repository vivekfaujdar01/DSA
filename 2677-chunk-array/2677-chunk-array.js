/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function (arr, size) {
    const ans = [];
    // If in arr.slice(i, i + size) , (i + size) is greater than the arr.length, JavaScript automatically treats it as arr.length.
    for (let i = 0; i < arr.length; i += size) {
        ans.push(arr.slice(i, i + size)); 
    }

    return ans;
};
