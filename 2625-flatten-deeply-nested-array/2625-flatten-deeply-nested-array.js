/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, depth) {
    const result = [];

    function dfs(current, d) {

        for (const item of current) {

            if (Array.isArray(item) && d < depth) {
                dfs(item, d + 1);
            } else {
                result.push(item);
            }
        }
    }

    dfs(arr, 0);

    return result;
};

// stack solution
// var flat = function(arr, n) {
//     const stack = [];
//     for (let i = arr.length - 1; i >= 0; i--) {
//         stack.push([arr[i], 0]);
//     }
//     const result = [];
//     while (stack.length) {
//         const [item, depth] = stack.pop();
//         if (Array.isArray(item) && depth < n) {
//             for (let i = item.length - 1; i >= 0; i--) {
//                 stack.push([item[i], depth + 1]);
//             }
//         } else {
//             result.push(item);
//         }
//     }
//     return result;
// };