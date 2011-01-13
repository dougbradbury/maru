(ns maru.test.common.game.rule
  (:use [maru.common.game.rule] :reload)
  (:use [clojure.test])
  (:use [maru.common.board.core]))

(deftest empty_boad_returns_all_moves
  (reset 9)
  (is (= (range (* size size)) (find-all-legal empty white))))

(deftest empty-board-size-5
  (reset 5)
  (is (= (range (* size size)) (find-all-legal empty white))))


(deftest one-move-size-5
  (reset 5)
  (is (= (range 1 25) (find-all-legal (play-black empty 0) white)) )
  )


(deftest suicide-in-corner-prevention
  (reset 5)
  (def board empty)
  (play-black board 1)
  (play-black board 5)
  (is (= 0 (find-all-dead-space board))) 
  )

;(deftest suicide-in-other-corner
;  (reset 5)
;  (is (= 4 (find-all-dead-space
;    [0 0 0 0 0
;     0 0 0 0 0
;     0 0 0 0 0
;     0 0 0 0 0
;     0 0 x 0 0]
;    ))))


(deftest wont-you-be-my-neighbor
  (is (= '(1 3 7) (neighbors 5 2 )))
  (is (= '(2 6 8 12) (neighbors 5 7 )))
  (is (= '(4 8 14) (neighbors 5 9 )))
  (is (= '(0 6 10) (neighbors 5 5)))
  (is (= '(17 21 23) (neighbors 5 22)))
  (is (= '(19 23) (neighbors 5 24)))
  (is (= '(15 21) (neighbors 5 20)))
  )