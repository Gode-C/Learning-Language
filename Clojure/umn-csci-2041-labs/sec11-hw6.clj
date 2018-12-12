

(use 'clojure.java.io)


(defn count-IP [] (let [counter (atom 0)]
                    (with-open [rdr (reader "NASA_access_log_Jul95_short")]
                      (doseq [line (line-seq rdr)]
                        (if (= nil (re-seq #"^\d{1,3}[.]\d{1,3}[.]\d{1,3}[.]\d{1,3}" line))
                          nil
                          (swap! counter inc))
                        )) @counter))


(defn find-private-IP [](let [counter (atom [])]
                          (with-open [rdr (reader "NASA_access_log_Jul95_short")]
                            (doseq [line (line-seq rdr)]
                              (if (= nil (re-seq #"^127[.]\d{1,3}[.]\d{1,3}[.]\d{1,3}" line))
                                (if (= nil (re-seq #"^10[.]\d{1,3}[.]\d{1,3}[.]\d{1,3}" line))
                                  (if (= nil (re-seq #"^192[.]168[.]\d{1,3}[.]\d{1,3}" line))
                                    (if (= nil (re-seq #"^192[.]88[.]99[.]\d{1,3}" line))
                                      nil
                                      (swap! counter conj (re-seq #"^192[.]88[.]99[.]\d{1,3}" line)))
                                    (swap! counter conj (re-seq #"^192[.]168[.]\d{1,3}[.]\d{1,3}" line)))
                                  (swap! counter conj (re-seq #"^10[.]\d{1,3}[.]\d{1,3}[.]\d{1,3}" line)))
                                (swap! counter conj (re-seq #"^127[.]\d{1,3}[.]\d{1,3}[.]\d{1,3}" line)))
                              )) @counter))

(defn count-request-on-dates [] (let [counter (atom 0)]
                                  (with-open [rdr (reader "NASA_access_log_Jul95_short")]
                                    (doseq [line (line-seq rdr)]
                                      (if (= nil (re-seq #"0[45]/Jul" line))
                                        nil
                                        (swap! counter inc))
                                      )) @counter))
(defn count-hosts [] (let [counter (atom [])]
                       (with-open [rdr (reader "NASA_access_log_Jul95_short")]
                         (doseq [line (line-seq rdr)]
                           (if (= nil (re-seq #"05/Jul/\d{4}:22:[012]\d{1}:\d{2}" line))
                             nil
                             (swap! counter conj (first (clojure.string/split line #" "))))
                           )) @counter))

(defn find-server-error [] (let [counter (atom [])]
                             (with-open [rdr (reader "NASA_access_log_Jul95_short")]
                               (doseq [line (line-seq rdr)]
                                 (if (= nil (re-seq #"5\d{2}\s\d+$" line))
                                   nil
                                   (swap! counter conj line))
                                 )) @counter))

(defn count-redirect [] (let [counter (atom 0)]
                          (with-open [rdr (reader "NASA_access_log_Jul95_short")]
                            (doseq [line (line-seq rdr)]
                              (if (= nil (re-seq #"3\d{2}\s\d+$" line))
                                nil
                                (swap! counter inc))
                              )) @counter))

(defn count-morethan50000 [] (let [counter (atom 0)]
                               (with-open [rdr (reader "NASA_access_log_Jul95_short")]
                                 (doseq [line (line-seq rdr)]
                                   (if (= nil (re-seq #"\d[56789]\d{4}$" line))
                                     nil
                                     (swap! counter inc))
                                   )) @counter))

(println (count-IP))
(println (find-private-IP))
(println (count-request-on-dates))
(println (count-hosts))
(println (find-server-error))
(println (count-redirect))
(println (count-morethan50000))
