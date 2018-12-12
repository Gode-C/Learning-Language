
(transpose [& args] (first args))

(defn transpose [& args] (first (first args)))


(defn reduceplus ([f coll] (loop [x 0 ans (first coll)] (if (= (inc x) (count coll)) ans (recur (inc x) (f ans (coll (+ x 1)))))))
([f val coll] (loop [x -1 ans val] (if (= (inc x) (count coll)) ans (recur (inc x) (f ans (coll (+ x 1)))))))
)




(defn reduceplus ([f coll] (reduceplus f (first coll) (rest coll)))
([f val coll] (loop [x -1 ans val] (if (= (inc x) (count coll)) ans (recur (inc x) (f ans (coll (+ x 1)))))))
)
