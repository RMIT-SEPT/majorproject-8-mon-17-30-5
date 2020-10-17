
import React from 'react';
import { render } from '@testing-library/react';
import App from './App';
import ShallowRenderer from 'react-test-renderer/shallow';

test('render app correctly', () => {
  const renderer = new ShallowRenderer();
  renderer.render(<App/>);
  const result = renderer.getRenderOutput();
  console.log(result);
  expect(result.props.children.type).toBe('div');
  
  // const { getByText } = render(<App/>);
  
  // const linkElement = getByText(/About us/i);
  // expect(linkElement).toBeInTheDocument();
});

