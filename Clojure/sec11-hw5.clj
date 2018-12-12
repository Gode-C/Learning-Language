
(def gamematrix (list '(3 3) '(0 5) '(5 0) '(1 1)))

(defn score [a b] (if (= a 'c)
                    (if (= b 'c)
                      (nth (nth gamematrix 0) 0)
                      (nth (nth gamematrix 1) 0))
                    (if (= b 'c)
                      (nth (nth gamematrix 2) 0)
                      (nth (nth gamematrix 3) 0))
                    ))


(defn compete-n-times [a b n]
  (let [p1 (atom []) p2 (atom [])]
    (loop [count1 n]
      (if (> count1 0)
        (do
          (swap! p1 conj (a @p1 @p2))
          (swap! p2 conj (b @p2 @ p1))
          (recur (dec count1)))
        (loop [score1 0 score2 0 count2 0]
          (if (= n count2)
            (println (format "The score for the player1 is %d, the score for the player2 is %d" score1 score2))
            (recur (+ score1 (score (nth @p1 count2) (nth @p2 count2)))
                   (+ score2 (score (nth @p2 count2) (nth @p1 count2)))
                   (inc count2)
                   ))
          )
        ))
    ))


(defn All-Defect "All-Defect" [a b] 'd)
(defn All-Cooperate "All-Cooperate" [a b] 'c)
(defn Random "Random" [a b] (let [k (rand-int 2)] (if (= k 0) 'c 'd)))
(defn Tit-for-Tat "Tit-for-Tat" [a b] (if (empty? a) 'c (last b)))


(compete-n-times All-Cooperate All-Defect 100)
(compete-n-times All-Cooperate Random 100)
(compete-n-times All-Cooperate Tit-for-Tat 100)
(compete-n-times All-Defect Random 100)
(compete-n-times All-Defect Tit-for-Tat 100)
(compete-n-times Random Tit-for-Tat 100)

(defn tit-for-two-tats "tit-for-two-tats" [a b] (if
                                                  (< (count b) 2)
                                                  'c
                                                  (if
                                                    (= (last b) 'd)
                                                    (if (= (nth b (- (count b) 1)) 'd)
                                                      'b 'c)
                                                    'c)))
(compete-n-times tit-for-two-tats All-Cooperate 100)
(compete-n-times tit-for-two-tats All-Defect 100)
(compete-n-times tit-for-two-tats Tit-for-Tat 100)
(compete-n-times tit-for-two-tats Random 100)