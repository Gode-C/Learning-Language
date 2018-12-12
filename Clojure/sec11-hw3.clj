
(println "hello, please load modular-inverse.clj\ncall (printresult) to see the testing result mentioned in hw")

;----------------- part 1 -------------------
(def p 6240322667N)                                         ; need long integer
(def q 6240323147N)                                         ; need long integer

(defn find-e [m] (let [a (rand-bigint m)] (loop [a a] (if (nil? (modular-inverse a m)) (recur (inc a)) a))))

;----------------- part 2 -----------------

;constructor & selector

;the constructor and selecter is same for public key and private key, so I didn't write another function for pravite key

(defn make-public-key [n e] (list n e))
(defn public-mod [publickey] (nth publickey 0))
(defn public-exp [publickey] (nth publickey 1))

;----------------- part 3 ----------------

;sting>number converter
(defn string->ascii [a] (for [x (seq a)] (- (int x) 32)))
(defn ascii-num91 [a] (loop [ind 0 b 0] (if (> (inc ind) (count a)) b (recur (inc ind)
                                                                             (+ b (* (nth a ind) ((fn [n] (reduce * (repeat n 91))) (- (count a) (inc ind)))))))))
(defn num91-ascii [a] (loop [a a result '()] (if (= 0 (mod a 91)) result (recur (quot a 91) (conj result (mod a 91))))))
(defn ascii->string [a] (apply str (map char (map (fn [x] (+ x 32)) a))))

;encrypt
(defn encrypt-num [number publickey] (expmod number (public-exp publickey) (public-mod publickey)))
(defn encrypt-word [text publickey] (encrypt-num (ascii-num91 (string->ascii text)) publickey))


;----------------- part 4 --------------------

(defn decrypt-word [text privatekey] (ascii->string (num91-ascii (expmod text (public-exp privatekey) (public-mod privatekey)))))



;------------------ part 5 ------------------

(defn mysplit [x] (map (fn [x] (apply str x)) (partition-by (fn[x] (= x \space)) x)))

(defn encrypt-msg [msg publickey] (map (fn [x] (encrypt-word x publickey)) (mysplit msg)))


;------------------- part 6 -----------------
(defn decrypt-msg [msg privatekey] (apply str (map (fn [x] (if (char? x) x (decrypt-word x privatekey))) (interpose \space msg))))


;----------------- bones question ------------

(defn encrypt-val [msg key] (encrypt-msg msg key))
(defn decrypt-val [msg key] (decrypt-msg msg key))

;---------------- testing & result --------------


(defn printresult []
  (def n (* p q))
  (def m (* (- p 1) (- q 1)))
  (def e (find-e m))
  (def d (modular-inverse e m))

  (def public-key (make-public-key n e))
  (def private-key (make-public-key n d ))

  (println (encrypt-word "chen3736" public-key))
  (println (decrypt-word (encrypt-word "chen3736" public-key) private-key))
  (println (encrypt-msg "c lovers do not die they get cast into void"  public-key))
  (println (decrypt-msg (encrypt-msg "c lovers do not die they get cast into void"  public-key) private-key))
  (println (encrypt-msg "lisp lovers get garbage collected"  public-key))
  (println (decrypt-msg (encrypt-msg "lisp lovers get garbage collected"  public-key) private-key))
  (println (encrypt-msg "some people say that emacs are the best"  public-key))
  (println (decrypt-msg (encrypt-msg "some people say that emacs are the best"  public-key) private-key))
  (println (encrypt-val "hello" private-key))
(println (decrypt-val (encrypt-val "hello"  private-key) public-key))
  )




