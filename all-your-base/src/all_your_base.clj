(ns all-your-base)

(defn- power [base exponent]
  (Math/pow base exponent))

(defn- one? [n]
  (= n 1))

(defn- digits->decimal [base digits]
  (->> digits
       (reverse)
       (map-indexed #(* %2 (power base %1)))
       (reduce +)
       int))

(defn- n->base-digits [desired-base decimal-number ]
  (loop [start decimal-number digs '()] 
    (if (zero? start)
      digs
      (recur (quot start desired-base) (conj digs (mod start desired-base))))))

(defn convert [original-base digits desired-base]
  (cond
    (or
     (neg? original-base)
     (neg? desired-base)
     (one? original-base)
     (one? desired-base)
     (empty? digits)
     (zero? original-base)
     (zero? desired-base)
     (some neg? digits)
     (some #(>= % original-base) digits)) nil
    (every? zero? digits) '(0)
    :else (->> digits
               (digits->decimal original-base)
               (n->base-digits desired-base))))


