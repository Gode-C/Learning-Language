 	
 	
(use '[clojure.string :only (split triml)])


(defn myfactorial [n csz]
  (let [parts (partition-all csz (range 1 (inc n)))
        myfn #(apply * %)]
    (reduce * (pmap myfn parts))))
    


;(partition-by (fn [n] (if (= n \newline) true false)) mytext)
;(def useful (first (partition-by (fn [n] (if (= n "\newline") true false)) mytext)))
;(map (fn [line] (apply str line)) (partition-by (fn [n] (if (= n \newline) true false)) mytext)))

(def useingit (split (slurp "test.txt") #"\n"))
(def nasas (split (slurp "NASA_access_log_Jul95_short") #"\n"))

(defn find-date [strvec] (pmap (fn [x] (re-seq #"\d{2}.\w{3}.\d{4}" x)) strvec))


(count (find-date nasas))
