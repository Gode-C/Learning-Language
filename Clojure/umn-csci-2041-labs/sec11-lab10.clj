(defmacro car [x] `(first ~x))

(defmacro my-if [b then x else y] `(if ~b ~x ~y))


(defn lazy-interleave [x y] (lazy-seq (concat (list (first x) (first y)) (lazy-interleave (next x) (next y)))))

(defn lazy-random [x] (lazy-seq (cons (rand-int x) (lazy-random x))))


(let [num (atom 1) val @num]
(swap! num inc)
(println "previous: " val)
@num)

(def ag (agent { }))
(defn action [m key]
(assoc m key 10))
(send ag action :b)
@ag


(def ^:dynamic x 1) 
(def ^:dynamic y 1) 


(binding [x 2 y 3]
(set! x (+ x y)))
