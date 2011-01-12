(ns maru.common.game.rule
  (:use [maru.common.board.core]))

; Given current board and color of player, return a list of all legal moves on the board, excluding "Ko".
; Definition of Ko: http://senseis.xmp.net/?Ko


(defn index-if-gray [position cell]
  (cond (= cell gray) position
    :else nil)
  )
 (defn find-all-legal [board color]
  (remove nil? (map index-if-gray (range (count board)) board))
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
