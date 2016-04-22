(ns sudoku-solver.core
  (require [clojure.core.matrix :refer [rows columns submatrix to-vector]]
           [sudoku-solver.boards :as board]))

(def offset-range (range 0 9 3))

(defn squares [board]
  (map to-vector
       (for [x-offset offset-range
             y-offset offset-range]
          (submatrix board x-offset 3 y-offset 3))))

(defn valid-set? [check-set] (= (set check-set) #{1 2 3 4 5 6 7 8 9}))

(def valid? (partial every? valid-set?))

(defn valid-solution? [board]
  (and
    (valid? (rows board))
    (valid? (columns board))
    (valid? (squares board))))

(valid-solution? board/valid)
(valid-solution? board/bad-rows)
(valid-solution? board/bad-cols)
(valid-solution? board/bad-squares)
