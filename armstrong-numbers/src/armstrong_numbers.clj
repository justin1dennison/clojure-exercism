(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn parse-int [c]
  (Integer/parseInt (str c)))

(defn sum-of-powers [xs power]
  (reduce + (map #(pow % power) xs)))


(defn armstrong? [num]
    (let [s (str num)
         length (count s)
         digits (map parse-int s)
         powsum (sum-of-powers digits length)]
    (= powsum num)))


