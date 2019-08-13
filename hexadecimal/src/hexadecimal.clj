(ns hexadecimal)

(def lookup {\0 0 \1 1 \2 2 \3 3 \4 4 \5 5 \6 6 \7 7 \8 8 \9 9 \a 10 \b 11 \c 12 \d 13 \e 14 \f 15})

(defn- hex->decimal [idx digit]
  (* (lookup digit) (Math/pow 16 idx)))

(defn- valid? [n]
  (every? lookup n))

(defn hex-to-int [n]
  (if (valid? n)
    (->> n
         (reverse)
         (map-indexed hex->decimal)
         (reduce +)
         int)
    0))

