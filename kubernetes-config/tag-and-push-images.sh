gcloud auth login

docker tag net.mosur.food.ordering.system/order.service:$1 europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/order.service:$1
docker tag net.mosur.food.ordering.system/payment.service:$1 europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/payment.service:$1
docker tag net.mosur.food.ordering.system/restaurant.service:$1 europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/restaurant.service:$1
docker tag net.mosur.food.ordering.system/customer.service:$1 europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/customer.service:$1

docker push europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/order.service:$1
docker push europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/payment.service:$1
docker push europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/restaurant.service:$1
docker push europe-west4-docker.pkg.dev/food-ordering-system-346904/food-ordering-system-repository/customer.service:$1

