class Node:
    def __init__(self, data=None):
        self.link = None
        self.data = data

    def __repr__(self):
        return str(self.data) if self.data else "Empty"

