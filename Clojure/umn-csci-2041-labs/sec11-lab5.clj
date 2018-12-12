(defn num-digits [a] (if (> a -1) (count (seq (str a))) ("not a postive integer!")))


(defn from-dec [numb base] (list* (if (= 0 (quot numb base)) (vector numb) (conj (from-dec (quot numb base) base) (mod numb base)))))

(defn to-dec [numb base] (loop [a (rseq  numb) b base c 0] (if (= 0 (count a)) c (recur (rest a) b (+ c (* (first a) (reduce * (repeat (dec (count a)) b))))))))

(defn gcd [a b] (if (zero? b) a (recur b (mod a b))))
