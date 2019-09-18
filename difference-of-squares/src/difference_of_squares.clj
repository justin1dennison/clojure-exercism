(ns difference-of-squares)

(defn square [n] (* n n))

(defn sum-of-squares [n]
  (->> (range 1 (inc n))
       (map square)
       (reduce + 0)))

(defn square-of-sum [n]
  (->> (range 1 (inc n))
       (reduce + 0)
       square))

(defn difference [n]
  (-
   (square-of-sum n)
   (sum-of-squares n)))
