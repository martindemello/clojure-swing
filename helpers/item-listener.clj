(ns swing.helpers.item-listener
  (:import (java.awt.event ItemListener ItemEvent)))

(defn add-item-listener
  [component f & args]
  (let [listener (proxy [ItemListener] []
		   (itemStateChanged [event]
		     (apply f event args))) ]
    (.addItemListener component listener)))

(defn item-selected?
  [event]
  (= (.getStateChange event) ItemEvent/SELECTED))

(defn item-deselected?
  [event]
  (= (.getStateChange event) ItemEvent/DESELECTED))

(defn get-item
  [event]
  (.getItem event))
