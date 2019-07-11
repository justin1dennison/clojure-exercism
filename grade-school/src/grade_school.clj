(ns grade-school)

(defn grade [school grade]
  (if (contains? school grade)
    (get school grade)
    []))

(defn add [school name grade]
  (if (contains? school grade)
    (assoc
     school
     grade
     (conj (get school grade) name))
    (assoc school grade [name])))

(defn- sort-map-values [[k v]]
  [k (into [] (sort v))])

(defn sorted [school]
  (->> school
    (map sort-map-values)
    (into (sorted-map))))
