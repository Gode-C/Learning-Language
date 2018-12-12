(ns hw01)

;question 01
(defn maxmul7 [a b] (if (< b a) nil (if (= 0 (mod b 7)) b (maxmul7 a (dec b)))))

;question 02
(defn sumcube [a b] (if (<= a b) (+ (* b (* b b)) (sumcube a (dec b))) 0))

;question 03
(defn drop2nd [a] (assoc (subvec a 1) 0 (get a 0)))

;question 04
(defn sumall [a b] (if (not= b 0) (if (= 0 (mod a b)) (+ b (sumall a (dec b))) (sumall a (- b 1))) 0))
(defn perfect [a] (true? (= (sumall a (dec a)) a)))

;question 05
(defn ave [a]  (/ (apply + a) (count a) ))
(defn stddev [a] (Math/sqrt (/ (apply + (for [x a] (* (- (ave a) x) (- (ave a) x)))) (dec (count a)))))

;question 06
(defn posel [a b] (if (not= (.indexOf a b) -1) (.indexOf a b) nil))

