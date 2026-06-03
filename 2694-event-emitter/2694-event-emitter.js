class EventEmitter {
    constructor() {
        this.events = new Map();
    }

    subscribe(eventName, callback) {

        if (!this.events.has(eventName)) {
            this.events.set(eventName, new Set());
        }

        const callbacks = this.events.get(eventName);

        callbacks.add(callback);

        return {
            unsubscribe: () => {
                callbacks.delete(callback);
            }
        };
    }

    emit(eventName, args = []) {

        const callbacks = this.events.get(eventName);

        if (!callbacks) {
            return [];
        }

        const result = [];

        for (const cb of callbacks) {
            result.push(cb(...args));
        }

        return result;
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */