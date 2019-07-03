(ns armstrong-numbers)

(defn pow [x n]
  (reduce * (repeat n x)))

(defn sum-of-powers [xs power]
  (reduce + (map #(pow % power) xs)))

(defn number-digits [k]
  (loop [n k result []]
    (if (<= n 0)
      (reverse result)
      (recur (quot n 10) (conj result (mod n 10))))))

(defn armstrong? [n]
  (let [digits (number-digits n)
        length (count digits)
        powsum (sum-of-powers digits length)]
    (= powsum n)))


