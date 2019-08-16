(ns grains)

(defn power [base exp]
  (->> (bigint base)
       (repeat exp)
       (reduce * 1)))

(defn square [n] 
    (power 2 (dec n)))

(defn total []
  (->> (range 1 65)
       (map square)
       (reduce + 0)))
