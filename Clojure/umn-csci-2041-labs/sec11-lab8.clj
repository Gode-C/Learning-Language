(defmacro avg [& numbs] `(float (/ (+ ~@numbs) ~(count numbs))))

		

(defmacro avg-vect [numbs] (list '/ (list 'apply '+ numbs) (list 'count numbs)))

(defmacro numif [e p z n] (list 'if (list '< 0 e) p (list 'if (list '= 0 e) z n)))

(defmacro ntimes [n & body] (let [sym (gensym)] `(loop [~sym ~n] (if (< 0 ~sym) (do ~@body (recur (dec ~sym)))))))

(defmacro my-dotimes [[x init end] & body] (let [sym (gensym)] `(loop [~sym ~init] (if (> ~end ~sym) (do (def x ~sym) ~@body (recur (inc ~sym)))))))

