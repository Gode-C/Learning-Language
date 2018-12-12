(defn replace-with-sum [a] (loop [sum 0 b (list* a) result (vector)]
                             (if (not= nil (first b))
                               (if (integer? (first b))
                                 (recur (+ sum (first b)) (rest b) result)
                                 (recur sum (rest b) (conj result (first b))))
                               (list* (conj result sum)))
                             ))

(defn running-sum [a] (loop [a a b [] c (first a)]
                        (if (nil? (first a))
                          b
                          (recur (rest a) (conj b c) (if (nil? (first (rest a)))
                                                       0
                                                       (+ c (first (rest a))))))))


(defn expand [a] (loop [a a b ()]
                   (if (nil? (first a))
                     (remove list? b)
                     (if (list? (first a))
                       (recur (rest a) (concat b (repeat (first (first a)) (first (rest (first a))))))
                       (recur (rest a) (concat b (list (first a)))))
                     )))


(defn factors [r n] (remove (fn [x] (not= 0 (mod n x))) r))


(defn string->ascii [a] (for [x (seq a)]
                          (- (int x) 32)))


(defn ascii-num96 [a] (loop [ind 0 b 0]
                        (if (> (inc ind) (count a))
                          b
                          (recur (inc ind)
                                 (+ b
                                    (* (nth a ind)
                                       ((fn [n] (reduce * (repeat n 96)))
                                         (- (count a) (inc ind)))))))))


(defn make-dict [a] (loop [ind 0 b {}]
                      (if (< ind (count a))
                        (recur (inc ind) (assoc b (str (nth a ind)) (ascii-num96 (string->ascii (nth a ind)))))
                        b)))


(defn in-dict [dic word] (get dic word))


