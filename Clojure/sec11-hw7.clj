(ns circles.core
  (:require [quil.core :as q :include-macros true]
            [quil.middleware :as m]))

;;; Circles Game Basic Setup
;;; CSCI 2041 Homework #7
;;; Spring 2016

;;; Constants
(def speed 5)                          ;maximm speed circles move


;Game Link : http://quil.info/sketches/show/-KG_G2R-OjqJjEzGIjS_

;--------------------The Color Thief-------------------------------
;
;You are a color thief, you steal color from everything you touch
;Now, you need to steal color from those flying circles.
;The faster the better! let's see what you can do!
;
;Controls:
;Arrow key for movement
;Y for start a new game
;P for pause the game
;secret key for not start a new game
;click on the window to change the background color
;
;Click on the window once before start!
;
;
;
;
;
;---------------------------------------------------------------------




;---------------------------------------------------------------------
; Setup
;---------------------------------------------------------------------

(defn make-circle 
  "Creates a circle with a random color and set speed and heading."
   [x y]
  (let [angle (rand q/TWO-PI)          ;random angle
        cur-speed (+ (rand speed) 1)]  ;random speed up to our constant
       {:x x                           ;set this circle's x
    	:y y                           ;set this circle's y
        :size (+ 10 (rand 15))         ;set random diameter 
    	:color (rand 255)              ;make this colorful      
    	:eat 255
        :speed cur-speed               ;set this circle's speed
    	:heading angle}                ;set this circle's heading
    ))                                 ;returns circle



(defn make-monster [x y]
  {:x x
   :y y
   :speed 5
   :heading 0})


(defn setup 
  "Set up a sketch and return initial state."
  []
  (q/frame-rate 30)                    ;frequency update and draw functions
  (q/color-mode :hsb)                  ;how we represent colors
  (let [size (q/width) 
        n 20
        bg 50]
       (q/background bg)               ;nice light grey color for the bg
       ;; need to make n circles of random sizes
       ;; here we make only one circle in a list
       {:monster (make-monster 50 50)
        :circles 
        (take 20 (repeatedly
               (fn [] (make-circle 
                        (+ 50 (rand (- size 100))) 
                        (+ 50 (rand (- size 100)))))))
        :running? true                 ;so we can pause and unpause in update
        :n n                           ;how many circles
        :size size                     ;how big is the sketch
        :bg bg                         ;we might want to change this later
        :score 0
        :gameover? true
        :try? true
        }))
    
;---------------------------------------------------------------------
; Update functions
;---------------------------------------------------------------------


 (defn bounce-back [c size] 
   (cond (> (+ (:y c) (:size c)) size)
     (update-in c [:heading] (fn [n] (- q/TWO-PI n)))
         (< (- (:y c) (:size c)) 0)
     (update-in c [:heading] (fn [n] (- q/TWO-PI n)))
         (> (+ (:x c) (:size c)) size)
     (update-in c [:heading] (fn [n] (- q/PI n)))
         (< (- (:x c) (:size c)) 0)
     (update-in c [:heading] (fn [n] (- q/PI n)))
         :else c
         ))
(defn move-circle 
  "Moves a circle according to its speed and heading"
  [c state]
  (let [cir (bounce-back c (:size state))]
        (update-in 
          (update-in cir [:x] 
                     (fn [n] (+ n (* (:speed cir) (q/cos (:heading cir))))))
          [:y] (fn [n] (+ n (* (:speed cir) (q/sin (:heading cir)))))))
  )
 
 (defn game-over? [state] 
   (if (:gameover? state)
     true
   (loop [mycount 0 numb 0] 
     (if (< mycount (count (:circles state)))
       (recur 
         (inc mycount) 
         (+ numb (:eat (nth (doall (:circles state)) mycount))))
       (if (= 0 numb) true false) 
                              ))))
 


(defn score-up [score state] (if (:gameover? state) score (inc score)))

(defn newgame [thisc state] (assoc-in thisc [:eat] 255))

(defn check-eat [thisc state] 
    (if (and
          (and (< (+ (:x thisc) (mod (:size thisc) 2)) (+ 50 (:x (:monster state)))) 
               (> (- (:x thisc) (mod (:size thisc) 2)) (:x (:monster state))))
          (and (< (+ (:y thisc) (mod (:size thisc) 2)) (+ 50 (:y (:monster state)))) 
               (> (- (:y thisc) (mod (:size thisc) 2)) (:y (:monster state)))))
      (assoc-in thisc [:eat] 0)
      thisc))
 
(defn update-circles-newgame 
  [circles state] 
  (map (fn [c] (newgame c state)) circles))
 
(defn update-circles 
  "Moves each circle and returns updated vector of circles."
  [circles state] 
  (map (fn [c] (move-circle (check-eat c state) state)) circles))




(defn update-state 
  "Updates sketch state. If it is paused, then the state is returned unmodified."
  [state]
  (if (:gameover? state)
    (assoc state :circles (update-circles-newgame (:circles state) state))
  (if (:running? state)
      ;add some movement and update functions so the next line moves circles
      (assoc state :circles (update-circles (:circles state) state)
        		   :score (score-up (:score state) state)
        		   :gameover? (game-over? state)
        )
      state)))
;---------------------------------------------------------------------
; Draw functions
;---------------------------------------------------------------------

(defn draw-circle 
  "Draws an individual circle with correct color, location, and size."
  [c] 
  (q/fill (:color c) (:eat c) 255)
  (q/ellipse (:x c) (:y c) (:size c) (:size c)))

(defn draw-monster
  "draw"
  [monster]
  (let [x (:x monster) y (:y monster)]
  (q/fill 103 255 255)
  (q/rect x y 50 50)
  (q/fill 0 0 0)
  (q/rect (+ x 10) (+ y 10) 10 10) 
  (q/rect (+ x 30) (+ y 10) 10 10)
  (q/fill 0 250 250)
  (q/rect (+ x 10) (+ y 30) 30 10)
  ))


(defn get-score [state] (:score state))

(defn draw-state 
  "Draws the sketch state."
  [state]
  (q/background (:bg state))                    ;update the background
  (q/stroke 1)                                  ;how wide should the lines be

  (if (:gameover? state)
    
    (if (= 0 (:score state))
      (do
        (q/text-size 25)
        (q/text "Welcome, Color Monster" 40 100)
        (q/text "Your goal is to steal Color from the balls" 40 130)
        (q/text "You can do that by step over them" 40 160)
        (q/text "Use Arrow key to move, 'p' for pause" 40 230)
        (q/text "Click on this window to change the color" 40 260)
        (q/text "press 'y' to start, Good Luck!" 40 300)
        
        )
    (do
      (q/text-size 30)
      (q/text "Good Job!" 140 130)
      (q/text "Your Time is" 140 160)
      (q/text (/ (get-score state) 30) 140 190)
      (q/text "second" 280 190)
      (q/text "press 'y' to try again" 140 300)
      (if (:try? state) (q/text "press 'n' to not try again" 140 330) 
        (q/text "Come On!" 140 330))
      ))
    
    (do
  (dorun (map draw-circle (:circles state)))    ;map is lazy
  (draw-monster (:monster state))
  (q/fill 0)
  (q/text-size 20)
     (q/text "Time: " 100 30)
  (q/text (/ (get-score state) 30) 100 50)
      ))
)



;---------------------------------------------------------------------
; User interaction functions
;---------------------------------------------------------------------

(defn mouse-clicked 
  "Changes background color to different shades of grey."
  [state event]
  (update-in state [:bg] (fn [n] (rand-int 255))))

(defn key-pressed 
  "Process key event.  p will pause/unpause everything."
  [state event]
  (condp = (:key event)
    :p (update-in state [:running?] not)
    
    :up (if 
          (> (:y (:monster state)) 0)
          (assoc-in state [:monster :y] (- (:y (:monster state)) 10))
          (assoc-in state [:monster :y] 0))
    
    :down (if 
          (< (:y (:monster state)) 450)
    	  (assoc-in state [:monster :y] (+ 10 (:y (:monster state))))
          (assoc-in state [:monster :y] 450))
    
    :left (if 
          (> (:x (:monster state)) 0)
          (assoc-in state [:monster :x] (- (:x (:monster state)) 10))
          (assoc-in state [:monster :x] 0))
    
    :right (if 
          (< (:x (:monster state)) 450)
    	  (assoc-in state [:monster :x] (+ 10 (:x (:monster state))))
          (assoc-in state [:monster :x] 450))
    
    :y (assoc state :gameover? false
         :score 0
         :try? true)
    :n (assoc-in state [:try?] false)
    state))




(q/defsketch circles
    :host "host"
    :size [500 500]                ;we need a square canvas
    :setup setup                   ;getting things started, setting initial state
    :update update-state           ;the function to update the state
    :draw draw-state               ;the necessary draw function

    :mouse-clicked mouse-clicked   ;this is our mouse click event
    :key-pressed key-pressed       ;this is our keyboard input event
    :middleware [m/fun-mode])      ;this gives us the ability to have state

