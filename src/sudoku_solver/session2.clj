(ns sudoku-solver.session2
  (require [sudoku-solver.boards :as board]))

board/valid

(def rows identity)

(defn columns [board]
  (apply map vector board))

(defn valid-set? [sudoku-set]
  (= #{1 2 3 4 5 6 7 8 9} (set sudoku-set))
  )

(defn valid? [board]
  (every? valid-set? board))

  (defn squares [board]
    (for [x-offset (range 0 9 3)
          y-offset (range 0 9 3)]
      (for [x (map #(+ x-offset %)(range 3))
            y (map #(+ y-offset %)(range 3))]
        (get-in board [x y]))))


(defn valid-solution? [board]
    (and
      (valid? (rows board))
      (valid? (columns board))
      (valid? (squares board))))

(valid-solution? board/valid)
(valid-solution? board/bad-rows)
(valid-solution? board/bad-cols)
(valid-solution? board/bad-squares)
