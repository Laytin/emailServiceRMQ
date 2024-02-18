# SpringRESTApp Extension
It's extension for SpringRESTApp that accepted RabbitMQ messages,which are intended to notify the user by EMAIL (!)
There is 2 queues.
  - create: when user create a join request, we need to notify owner of this trip.
  - edit: when owner accept or cancel join request, we need top notify passenger.
