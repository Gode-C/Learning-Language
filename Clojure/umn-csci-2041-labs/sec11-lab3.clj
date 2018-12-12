(defn remove-dupl [a b] (let [remove (fn [x y] (remove (set x) (set y)))] (concat (remove a b) (remove b a))))

(defn reduce [f coll] (loop [x 0 ans (first coll)] (if (= (inc x) (count coll)) ans (recur (inc x) (f ans (coll (+ x 1)))))))



(defn reduceplus ([f coll] (reduceplus f (first coll) (rest coll)))
([f val coll] (loop [x -1 ans val] (if (= (inc x) (count coll)) ans (recur (inc x) (f ans (nth coll (+ x 1)))))))
)



