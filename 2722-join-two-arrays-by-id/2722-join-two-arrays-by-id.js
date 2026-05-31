/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */

 // Object.values() - It returns an array of an object's own enumerable property values in the same order that JavaScript uses for property enumeration:
// Integer-like keys ("0", "1", "2", etc.) are returned in ascending numeric order.
// Other string keys are returned in insertion order.
// Symbol keys are ignored.

// {...a, ...b} it is merging properties from two objects and if both have same properties then b's property will override a's property
// But when we merge two array like [...a, ...b] it workd concatenates all values, even duplicates.

var join = function(arr1, arr2) {

    const obj = {};

    for (const item of arr1) {
        obj[item.id] = item;
    }

    for (const item of arr2) {
        obj[item.id] = {
            ...obj[item.id],
            ...item
        };
    }

    return Object.values(obj).sort((a, b) => a.id - b.id); // here if we don't use sort() method it will still give us correct answer
};