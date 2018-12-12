(def mytext (slurp "test.txt"))
(clojure.string/upper-case mytext)
(spit "copy-test.txt" (clojure.string/upper-case mytext))
(spit "copy-test.txt" "to be continued." :append true)
(use 'clojure.java.io)

(with-open [rdr (reader "test.txt")]
  (doseq [line (line-seq rdr)]
         (println line)))
         
(with-open [wrtr (writer "newtest.txt")]
      (.write wrtr "Write whatever you want."))
