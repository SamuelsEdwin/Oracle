#marks an event
import uuid
import hashlib
import time


def mark_event(driver_id, officer_id):
    salt = uuid.uuid4().hex
    timestamp = time.strftime('D %Y-%m-%d T %H:%M', time.gmtime())
    mark = hashlib.sha3_256(salt.encode() + driver_id.encode() + officer_id.encode() + timestamp.encode())
    return salt.encode(), timestamp.encode(), mark.hexdigest()

#def check event(driver_id,officer_id):



