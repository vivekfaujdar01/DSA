var TimeLimitedCache = function() {
    map = new Map();
    var timer;
};

TimeLimitedCache.prototype.set = function(key, value, duration) {
    let res = map.has(key);
    if(res) {
        clearTimeout(map.get(key).timer);
    }
    timer = setTimeout(()=>map.delete(key), duration);
    map.set(key, {value: value, timer: timer} );
    return res;
};

TimeLimitedCache.prototype.get = function(key) {
    if(map.has(key)) return map.get(key).value;
    return -1;
};

TimeLimitedCache.prototype.count = function() {
    return map.size;
};