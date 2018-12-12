(defn lazy-rand [x] (lazy-seq (cons(rand-int x) (lazy-rand x))))

(defn lazy-scale [a b] (lazy-seq (cons (* b (first a)) (lazy-scale (rest a) b))))

(defn lazy-running-sum [v] (lazy-seq (cons (first v) (map (fn [x] (+ x (first v))) (lazy-running-sum(rest v))))))

(defn lazy-interleave [a b] (lazy-seq (cons (first a) (cons (first b) (lazy-interleave (rest a) (rest b))))))

(defn lazy-remove-dup [a] (lazy-seq (cons (first a) (if (nil? (first a)) () (lazy-remove-dup (remove (fn [x] (= x (first a))) (rest a)))))))

