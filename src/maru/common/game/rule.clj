(ns maru.common.game.rule
  (:use [maru.common.board.core]))

; Given current board and color of player, return a list of all legal moves on the board, excluding "Ko".
; Definition of Ko: http://senseis.xmp.net/?Ko


(defn index-if-gray [position cell]
  (cond (= cell gray) position
    :else nil)
  )
(defn find-all-legal [board color]
  (remove nil? (map-indexed index-if-gray board))
  )

(defn in-range [size]  (fn[n] (and (>= n 0) (< n (* size size)))))

(defn neighbors [size position]
  (filter (in-range size) (list
    (to-pos (to-x position) (dec (to-y position)))
    (cond (= (to-x position) 0) -1 :else (to-pos (dec (to-x position)) (to-y position)))
    (cond (= (to-x position) (- size 1)) -1 :else (to-pos (inc (to-x position)) (to-y position)))
    (to-pos (to-x position) (inc (to-y position)))
    ))

  )

(defn find-all-dead-space [board]
  0
  ;    (map (dead-spot (west) (range (count board)))
  )
; Given current board, color and position of a stone, return a list of stones to be captured/removed from board.
; Definition of capture: http://senseis.xmp.net/?Capture
; (defn capture-stones [board color position] '())

; Given current board, color and position of a stone, count the number of its liberties.
; Definition of a liberty: http://senseis.xmp.net/?Liberty
; Definition of a group: http://senseis.xmp.net/?Group
; (defn liberty-count [board color pos] count)

; Given current board and color of player, return a list of all atari moves on the board
; Definition of atari: http://senseis.xmp.net/?Atari
; (defn find-all-atari [board color] '())
