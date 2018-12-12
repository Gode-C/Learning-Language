(defn same-elements? [a b] (= (set a) (set b)))

(defn sum-harmonic [a] (double (if (= 1 a) 1 (+ (/ 1 a) (sum-harmonic (dec a))))))

(defn collect [a n] (if (<= (count a) n) (list a) (conj (collect (drop n a) n) (list (take n a)))))


 (defn interleave [a b] (list* (loop [a a b b c []] (if (and (= 0 (count a)) (= 0 (count b))) c (recur (rest a) (rest b) (conj c (first a) (first b)))))))
 
 (let [secret (atom "mistery")]
  (defn read-secret [] @secret)
  (defn multiply-secret [n] (swap! secret (fn [x y] (repeat y x)) n)))
  
