(ns sudoku-solver.session1
  (require [sudoku-solver.boards :as board]))


(defn valid-block? [block]
  (= #{1 2 3 4 5 6 7 8 9} (set block)))

(def rows identity)

(defn columns [blocks]
  (apply (partial map vector) blocks))


(defn get-squares [group-of-three-rows]
  (->> group-of-three-rows
       (map (partial partition 3))
       (apply (partial map concat))))

(defn squares [board]
  (->> board
       (partition 3)
       (map get-squares)
       (apply concat)))

(def valid? (partial every? valid-block?))

(defn valid-solution? [board]
  (and
    (valid? (rows board))
    (valid? (columns board))
    (valid? (squares board))))

(valid-solution? board/valid)
(valid-solution? board/bad-rows)
(valid-solution? board/bad-cols)
(valid-solution? board/bad-squares)


