(ns collatz-conjecture)

(defn collatz [num]
  (if (<= num 0)
    (throw (Exception. "uh oh"))
    (loop [count 0 value num]
      (if (= value 1)
        count
        (recur (inc count)
               (if (even? value)
                 (quot value 2)
                 (+ (* 3 value) 1)))))))
