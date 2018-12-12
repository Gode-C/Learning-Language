(def mytext (slurp "tmpdata.txt"))

(use 'clojure.java.io)

(defn readf [] (with-open [rdr (reader "tmpdata.txt")]
  (doseq [line (line-seq rdr)]
         (prn line))))
             
         
(defn printip [] (print (re-seq #"\d{1,}[.]\d{1,}[.]\d{1,}[.]\d{1,}?" mytext)
(re-seq #"\w*[.]\w*[.]com" mytext) (re-seq #"\w*[.]\w*[.]net" mytext) (re-seq #"\w*[.]\w*[.]jp" mytext)))


(re-seq #"\d{1,6}\n" mytext)
