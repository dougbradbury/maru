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


(deftest one-move-size-2
  (reset 5)
 
  (is (= (range 1 25) (find-all-legal (play-black empty 0) white)) )
  )