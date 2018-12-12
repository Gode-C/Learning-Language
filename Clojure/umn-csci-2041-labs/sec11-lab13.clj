(ns my.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :hsb)
  {:color 0
   :angle 0})

(defn update-state [state]
  (let [{:keys [color angle]} state]
    {:color (mod (+ color 0.7) 255)
     :angle (mod (+ angle 0.05) q/TWO-PI)}))

(defn draw-state [state]
  (q/background 175)
  (q/fill (:color state) 255 255)
  (let [angle (:angle state)
        x (* 180 (q/cos angle))
        y (* x (q/sin angle))]
    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      (q/ellipse x y 120 120)
      (q/ellipse (- x 20) (- y 20) 10 10)
      (q/ellipse (+ x 20) (- y 20) 10 10)
      
      (q/arc x (+ y 20) 50 20 0 q/HALF_PI)
      
      ))
    (let [angle (:angle state)
        y (* 180 (q/cos angle))
        x (* y (q/sin angle))]
    (q/with-translation [(/ (q/width) 2)
                         (/ (q/height) 2)]
      (q/triangle x y (- x 30) (- y 60) (+ x 30) (- y 60))
      (q/triangle x (- y 80) (- x 30) (- y 20) (+ x 30) (- y 20))))
  
  )

(defn mouseclick [state] (update-in state [:color] (fn [n] (mod (+ n (rand-int 255)) 255))))

(q/defsketch my
  :host "host"
  :size [500 500]
  :setup setup
  :update update-state
  :draw draw-state
  :mouse-clicked mouseclick
  :middleware [m/fun-mode])
