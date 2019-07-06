(ns hamming)

(defn zip [x y]
  (map vector x y))

(defn distance [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (reduce
     (fn [acc [k v]]
       (if (not (= k v))
         (inc acc)
         acc))
     0
     (zip strand1 strand2))))
