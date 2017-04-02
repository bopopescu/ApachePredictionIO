"""
Import sample data for E-Commerce Recommendation Engine Template
"""

import predictionio
import argparse
import random

SEED = 3

def import_events(client,item_id,category):
# Create a new item or set existing item's categories

	client.create_event(
	  event="$set",
	  entity_type="item",
	  entity_id=item_id,
	  properties={
    "categories" : category
  }
)
if __name__ == '__main__':
  parser = argparse.ArgumentParser(
    description="Import sample data for e-commerce recommendation engine")
  parser.add_argument('--access_key', default='invalid_access_key')
  parser.add_argument('--url', default="http://localhost:7070")

  args = parser.parse_args()
  print args

  client = predictionio.EventClient(
    access_key=args.access_key,
    url=args.url,
    threads=5,
    qsize=500)

  item_ids = {'Mobile Phone1':'mobile','Mobile Phone2':'mobile','Mobile Phone3':'mobile','Smart Phone':'mobile','Wireless 			   Phone':'mobile','Speakers':'audio','Headphone':'audio','Audio Player':'audio','Audio-speaker':'audio','Laptop':'computer','Notebook':'computer','Kids  Toy':'computer','Refrigerator':'household','LED Tv':'household','Washing Machine':'household','Grinder':'kitchen','Water Purifier':'kitchen','Coffee Maker':'kitchen','Wireless Speaker':'audio','Red Mobile':'mobile','Wireless Phone':'mobile','Golden Tablet':'computer','Asus Tablet':'computer'} 
 
  for key, value in item_ids.viewitems():
    import_events(client,key,item_ids[key])
